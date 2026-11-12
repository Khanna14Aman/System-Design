---
name: add-topic
description: Add a new topic to System_Design — fetches content from a URL, picks a destination folder, creates a numbered subfolder, and writes a quick-revision notes file.
---

# add-topic skill

You are helping the user add a new study topic to their System_Design repository. Follow these steps **in order**. Do not skip a step or proceed until the user has answered.

---

## Step 1 — Ask for the source link

Use `AskUserQuestion` to ask:

> "Paste the source URL you want to use for this topic."

Single text input. Store the URL for Step 4.

---

## Step 2 — Ask which parent folder to use

Run `ls` (or use `Glob`/`Bash`) to list every **immediate child directory** of the workspace root (`C:\Users\I752737\System_Design`) that is not hidden (does not start with `.`). Present only the directory names, not full paths.

Use `AskUserQuestion` to ask:

> "Which folder should the new topic go into? Available folders: [list them as options]"

Present the discovered folders as distinct selectable options. Store the chosen folder name.

---

## Step 3 — Determine the next number and ask for the topic name

Inside the chosen parent folder, list all subdirectories whose names begin with a digit (pattern `[0-9]*`). Extract the leading integer from each name, find the maximum, and add 1 to get `NEXT_NUMBER`.

Use `AskUserQuestion` to ask:

> "What is the topic name? (e.g. `Rate_Limiting`, `Message_Queue`). The folder will be created as `{NEXT_NUMBER}_<TopicName>`."

Sanitise the user's answer: replace spaces with `_`, remove any characters that are not alphanumeric or `_`.

Construct the full folder path:
```
C:\Users\I752737\System_Design\<chosen_parent>\<NEXT_NUMBER>_<TopicName>
```

---

## Step 4 — Fetch and analyse the source content

Use `WebFetch` with the URL from Step 1. Ask it to:

> "Extract all key concepts, definitions, trade-offs, and important points for a system design interview. Return raw extracted content."

---

## Step 5 — Create the folder and write the notes file

1. Create the new folder (use `Bash` with `mkdir -p`).
2. Inside it create `README.md` using the `Write` tool.

### README.md rules

The file must be **concise and interview-focused**. Cover all relevant information about the topic — include types, benefits, pros/cons, trade-offs, and real-world examples wherever they apply. Do not omit a section just because the source URL did not mention it; use your knowledge to fill it in.

Use this exact structure:

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
If a section is genuinely not applicable for the topic (e.g. "Types of" for a concept that has no recognised subtypes), omit that section rather than padding it.

---

## Step 6 — Confirm

After writing the file, print one line:

> "Created: `<relative_path_to_new_folder>/README.md`"

---

## Step 7 — Offer to commit and push to GitHub

Use `AskUserQuestion` to ask:

> "Do you want to commit and push this to GitHub?"

Offer two options: **Yes** and **No**.

### If the user chooses No

Print: "Changes saved locally. Skipping git commit."  
Stop here.

### If the user chooses Yes

Run the following git commands **in order** using `Bash`. Stop and report the error if any command fails.

1. Verify the working tree is inside a git repo:
   ```bash
   git -C "C:\Users\I752737\System_Design" status
   ```

2. Stage only the new folder:
   ```bash
   git -C "C:\Users\I752737\System_Design" add "<relative_path_to_new_folder>"
   ```

3. Commit with a descriptive message that includes the topic name and parent folder:
   ```bash
   git -C "C:\Users\I752737\System_Design" commit -m "Add <NEXT_NUMBER>_<TopicName> notes to <chosen_parent>"
   ```

4. Push to the remote (use the current branch):
   ```bash
   git -C "C:\Users\I752737\System_Design" push
   ```

After a successful push, print one line:

> "Pushed: `<chosen_parent>/<NEXT_NUMBER>_<TopicName>` committed and pushed to GitHub."
