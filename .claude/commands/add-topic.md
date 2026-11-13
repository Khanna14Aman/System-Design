---
name: add-topic
description: Add a new topic to System_Design — fetches content from a URL, prepares interview revision notes, picks a destination folder, suggests a numbered folder name, writes the notes, and offers to push to GitHub.
---

# add-topic skill

You are helping the user add a new study topic to their System_Design repository. Follow these steps **in order**. Do not skip a step or proceed until the user has answered.

---

## Step 1 — Ask for the source URL

Ask the user in plain text (do **not** use `AskUserQuestion` — it needs at least two options and cannot collect free text):

> "Paste the source URL you want to use for this topic."

Wait for the user to reply with the URL. Store it for Step 2.

---

## Step 2 — Fetch the content and prepare revision notes

Use `WebFetch` with the URL from Step 1. Ask it to:

> "Extract all key concepts, definitions, trade-offs, and important points for a system design interview. Return raw extracted content."

Then prepare **interview revision notes** from the extracted content. The notes must be concise and interview-focused — see the README structure in Step 7.

---

## Step 3 — Cover everything from the source, skip what you already have

- **Cover all relevant information available at the source URL.** Do not omit a section just because the source phrased it differently; use your own knowledge to fill in types, benefits, pros/cons, trade-offs, and real-world examples wherever they apply.
- **Do not add overlapping information that is already covered in the existing notes.** Before finalising, scan the existing `README.md` files in the target parent folder:
  ```bash
  find "C:\Users\I752737\System_Design\<chosen_parent>" -name "README.md" | xargs grep -l -i "<TopicName keywords>"
  ```
  (Or use `Glob` + `Read` to sample relevant files.)
  - If a concept or section is **already well-covered** in an existing note, **do not repeat it**. Add a cross-reference line instead:
    > `> See also: [<ExistingTopicName>](<relative_path>)`
  - If the new topic **is essentially the same** as an existing one, **stop** and ask the user whether to create a separate note or update the existing one. Wait for confirmation.
  - If the overlap is **partial**, keep only what is new or additive and cross-reference the rest.

---

## Step 4 — Suggest the folder options

List every **immediate child directory** of the workspace root (`C:\Users\I752737\System_Design`) that is not hidden (does not start with `.`). Present only the directory names, not full paths.

Use `AskUserQuestion` to ask:

> "Which folder should the new topic go into?"

Present the discovered folders as distinct selectable options. Store the chosen folder name.

---

## Step 5 — Suggest the new folder name (latest number + relevant name)

Inside the chosen parent folder, list all subdirectories whose names begin with a digit (pattern `[0-9]*`). Extract the leading integer from each, find the maximum, and add 1 to get `NEXT_NUMBER`.

Derive the **most relevant topic name** from the fetched content (title-case words joined with `_`, e.g. `Web_Server_vs_Application_Server`).

Propose the folder name as `{NEXT_NUMBER}_<SuggestedTopicName>`.

---

## Step 6 — Let the user accept or rename

Use `AskUserQuestion` to confirm the folder name. Offer the suggested name as the first option, e.g.:

> "I suggest creating the folder `{NEXT_NUMBER}_<SuggestedTopicName>`. Use this name, or enter your own?"

Options:
- **Use `{NEXT_NUMBER}_<SuggestedTopicName>`** (recommended)
- **Enter name manually**

If the user picks "Other" / enters a name manually, sanitise it: replace spaces with `_`, remove any characters that are not alphanumeric or `_`, and prefix it with `{NEXT_NUMBER}_` if the number is missing.

Construct the full folder path:
```
C:\Users\I752737\System_Design\<chosen_parent>\<NEXT_NUMBER>_<TopicName>
```

---

## Step 7 — Create the folder and write the notes file

1. Create the new folder (use `Bash` with `mkdir -p`).
2. Inside it create `README.md` using the `Write` tool, containing the revision notes prepared in Step 2–3.

### README.md rules

The file must be **concise and interview-focused**. Use this exact structure:

```markdown
# <TopicName> — Quick Notes

## What is it?
<1–2 sentences, plain definition>

## Why it matters
<2–3 bullet points — the "so what" for interviews>

## Types of <TopicName>
| Type | How it works | Best for |
|---|---|---|
| ... | ... | ... |

## Key Concepts
| Concept | One-liner |
|---|---|
| ... | ... |

## How it works (flow)
<3–5 numbered steps or a short ASCII diagram — whichever is clearer>

## Benefits
| Benefit | Detail |
|---|---|
| ... | ... |

## Trade-offs
| Pro | Con |
|---|---|
| ... | ... |

## When to use / avoid
- **Use when:** ...
- **Avoid when:** ...

## Real-world examples
- **<Company/Product>:** <one line on how they use it>
- ...

## Common interview questions
- ...
- ...
- ...

## Golden rules (memorise these)
- ...
- ...
```

Keep every section tight. No padding, no filler. The whole file should be readable in under 3 minutes.
If a section is genuinely not applicable (e.g. "Types of" for a concept with no recognised subtypes), omit it rather than padding it.

After writing, print one line:

> "Created: `<relative_path_to_new_folder>/README.md`"

---

## Step 8 — Offer to commit and push to GitHub

Use `AskUserQuestion` to ask:

> "Do you want to push this to the GitHub repository?"

Offer two options: **Yes** and **No**.

### If the user chooses No

Print: "Changes saved locally. Skipping git commit." and stop here.

### If the user chooses Yes

Run these git commands **in order** using `Bash`. Stop and report the error if any command fails.

1. Verify the working tree is inside a git repo:
   ```bash
   git -C "C:\Users\I752737\System_Design" status
   ```
2. Stage only the new folder:
   ```bash
   git -C "C:\Users\I752737\System_Design" add "<relative_path_to_new_folder>"
   ```
3. Commit with a descriptive message:
   ```bash
   git -C "C:\Users\I752737\System_Design" commit -m "Add <NEXT_NUMBER>_<TopicName> notes to <chosen_parent>"
   ```
4. Push to the remote:
   ```bash
   git -C "C:\Users\I752737\System_Design" push
   ```

After a successful push, print one line:

> "Pushed: `<chosen_parent>/<NEXT_NUMBER>_<TopicName>` committed and pushed to GitHub."
