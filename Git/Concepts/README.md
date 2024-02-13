# Git Concepts

- [Git Documentation](https://git-scm.com/docs/git/en)
- [Git Downloads](https://git-scm.com/downloads)
- [Initial Git Configuration](https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup)

---
## Summary

- [Git Concepts](#git-concepts)
  - [Summary](#summary)
  - [File States](#file-states)
  - [Initial Git Configurations](#initial-git-configurations)
    - [Set up Username and Email](#set-up-username-and-email)
    - [Current Git configurations](#current-git-configurations)
    - [Default text editor for Git](#default-text-editor-for-git)
    - [Aliases for commands](#aliases-for-commands)
    - [Discard previous changes to the config](#discard-previous-changes-to-the-config)
  - [Initialization and Status](#initialization-and-status)
    - [Initialize Git versioning in a directory](#initialize-git-versioning-in-a-directory)
    - [Check the status of changes in Git](#check-the-status-of-changes-in-git)
  - [Diff](#diff)
    - [Compare two versions of files by tags](#compare-two-versions-of-files-by-tags)
    - [Show modifications to files since the last commit](#show-modifications-to-files-since-the-last-commit)
  - [Add](#add)
    - [Add changes to commit](#add-changes-to-commit)
  - [Remove](#remove)
    - [Remove files staged for commit](#remove-files-staged-for-commit)
  - [Commit](#commit)
    - [Save added changes with a message](#save-added-changes-with-a-message)
    - [Add all modified and untracked files to the staging area and commit](#add-all-modified-and-untracked-files-to-the-staging-area-and-commit)
  - [Log](#log)
    - [Show commit history](#show-commit-history)
  - [Remote](#remote)
    - [Specify where the versioning will be sent](#specify-where-the-versioning-will-be-sent)
  - [Push](#push)
    - [Link the local branch with a remote branch and push commits](#link-the-local-branch-with-a-remote-branch-and-push-commits)
    - [Force-push local repository to git](#force-push-local-repository-to-git)
    - [Force-push local repository (lease)](#force-push-local-repository-lease)
  - [Pull](#pull)
    - [Fetch updates from the remote repository to the local machine](#fetch-updates-from-the-remote-repository-to-the-local-machine)
  - [Cloning](#cloning)
    - [Clone a Github repository](#clone-a-github-repository)
  - [References](#references)
    - [Show which versions have been added so far](#show-which-versions-have-been-added-so-far)
  - [Cleaning](#cleaning)
    - [Remove untracked files from the working directory](#remove-untracked-files-from-the-working-directory)
  - [Branches, Checkout, and Switch](#branches-checkout-and-switch)
    - [Show available branches at the moment](#show-available-branches-at-the-moment)
    - [Create a new branch](#create-a-new-branch)
    - [Delete a local branch](#delete-a-local-branch)
    - [Delete a remote branch](#delete-a-remote-branch)
    - [Rename a local branch](#rename-a-local-branch)
    - [Switch to another branch or commit](#switch-to-another-branch-or-commit)
    - [Return to the previous branch, after switching with Switch](#return-to-the-previous-branch-after-switching-with-switch)
    - [Revert files to their last committed version](#revert-files-to-their-last-committed-version)
  - [Fetch](#fetch)
    - [Fetches information such as commits, branches, and tags from the remote repository](#fetches-information-such-as-commits-branches-and-tags-from-the-remote-repository)
    - [Fetches information about a branch from the remote server and stores it locally](#fetches-information-about-a-branch-from-the-remote-server-and-stores-it-locally)
  - [Cherry-Pick](#cherry-pick)
    - [Picks a specific commit from one branch to another without having to wait for the task to be completed to perform the entire merge](#picks-a-specific-commit-from-one-branch-to-another-without-having-to-wait-for-the-task-to-be-completed-to-perform-the-entire-merge)
  - [Bisect](#bisect)
    - [Initiates the process to find where a problem "started," in situations where there are many commits](#initiates-the-process-to-find-where-a-problem-started-in-situations-where-there-are-many-commits)
    - [After initiating the procedure, we must inform the good and bad commits](#after-initiating-the-procedure-we-must-inform-the-good-and-bad-commits)
    - [When the search process is finished, we can end the bisect with](#when-the-search-process-is-finished-we-can-end-the-bisect-with)
  - [Rebase](#rebase)
    - [Changes the base of a branch, brings changes from another branch](#changes-the-base-of-a-branch-brings-changes-from-another-branch)
    - [In case of conflict during rebase, to abort](#in-case-of-conflict-during-rebase-to-abort)
    - [After resolving a possible conflict in the text editor, we can continue the rebase process with](#after-resolving-a-possible-conflict-in-the-text-editor-we-can-continue-the-rebase-process-with)
    - [Merges changes made in more than one commit interactively](#merges-changes-made-in-more-than-one-commit-interactively)
  - [Tags](#tags)
    - [Lists all tags in the project](#lists-all-tags-in-the-project)
    - [Lists tags with their messages](#lists-tags-with-their-messages)
    - [Creates a tag on the current commit](#creates-a-tag-on-the-current-commit)
    - [Creates an "annotated" tag on the current commit](#creates-an-annotated-tag-on-the-current-commit)
    - [Creates a tag on a specific commit](#creates-a-tag-on-a-specific-commit)
    - [After tagging, you can view its information with](#after-tagging-you-can-view-its-information-with)
    - [Pushes an individual tag to the remote repository](#pushes-an-individual-tag-to-the-remote-repository)
    - [Pushes all tags from the local repository to the remote (not recommended)](#pushes-all-tags-from-the-local-repository-to-the-remote-not-recommended)
    - [Removes a tag locally](#removes-a-tag-locally)
    - [Removes a tag from the remote repository](#removes-a-tag-from-the-remote-repository)
  - [Stash](#stash)
    - [Saves tracked changes in memory without needing to commit](#saves-tracked-changes-in-memory-without-needing-to-commit)
    - [Lists saved changes in the stash](#lists-saved-changes-in-the-stash)
    - [Applies a saved change from the stash](#applies-a-saved-change-from-the-stash)
    - [Applies a saved change from the stash and removes it afterward](#applies-a-saved-change-from-the-stash-and-removes-it-afterward)
    - [Removes a saved change from the stash](#removes-a-saved-change-from-the-stash)
    - [Creates a branch from the saved stash](#creates-a-branch-from-the-saved-stash)
  - [Revert](#revert)
    - [Reverts a commit](#reverts-a-commit)
  - [Reset](#reset)
    - [Resets files to a given version (commit), ignoring local changes](#resets-files-to-a-given-version-commit-ignoring-local-changes)
    - [Erases one or more commits from the working area](#erases-one-or-more-commits-from-the-working-area)
  - [Extras](#extras)
    - [Merges changes from a development branch to a main one](#merges-changes-from-a-development-branch-to-a-main-one)
    - [In case of conflict during merge, to abort](#in-case-of-conflict-during-merge-to-abort)
    - [Create a .gitignore file to ignore files/directories in version control](#create-a-gitignore-file-to-ignore-filesdirectories-in-version-control)
  - [Graphic tools for Git usage](#graphic-tools-for-git-usage)

---
## File States

- `untracked`: not tracked by Git
- `staged`: in the "staging area" ready to be committed
- `unmodified`: unchanged since the last commit
- `modified`: changed since the last commit

**Notes:**
- `staged`, `unmodified`, and `modified` are part of the `tracked` state.

---
## Initial Git Configurations

### Set up Username and Email
```bash
$ git config <--global / --local / --system> user.name <"name">
$ git config <--global / --local / --system> user.email <"email address">
```

### Current Git configurations
```bash
$ git config <--list / --show-origin>
```

### Default text editor for Git
```bash
$ git config --global core.editor <"code --wait"> # Example for VSCode
```

### Aliases for commands
```bash
$ git config --global alias.<desired_command_name> <original_command>
e.g.:
  $ git config --global alias.s status # $ git s
  $ git config --global alias.line 'log --oneline' # $ git line
```

### Discard previous changes to the config
```bash
$ git config --global --unset alias.<alias_of_command>
```

---
## Initialization and Status

### Initialize Git versioning in a directory
```bash
$ git init
```

### Check the status of changes in Git
```bash
$ git status
```

---
## Diff

### Compare two versions of files by tags
```bash
$ git diff <tag_1> <tag_2>
```

### Show modifications to files since the last commit
```bash
$ git diff # (modified -> unmodified)
$ git diff --cached # (staged -> unmodified)
```

---
## Add

### Add changes to commit
```bash
$ git add <"file(s)" or . / -A / --all>
```

---
## Remove

### Remove files staged for commit
```bash
$ git rm --cached <file>
$ git rm --cached -r .
```

---
## Commit

### Save added changes with a message
```bash
$ git commit -m <"message">
```
**Notes:**

- To amend the message of a commit: `$ git commit --amend -m <"message">`.
- To add files to a past commit: add them and then `$ git commit --amend --no-edit`.
- With `$ git commit --amend`, the default text editor will open to "fix" the last commit.

### Add all modified and untracked files to the staging area and commit
```bash
$ git commit -a -m <"message">
```

---
## Log

### Show commit history
```bash
$ git log [<branch_name>, --oneline / -N / -p / --stat / --shortstat]
```
**Notes:**

- Use `q` to exit log view.

---
## Remote

### Specify where the versioning will be sent
```bash
$ git remote add origin <github_repository_url>
```

---
## Push

### Link the local branch with a remote branch and push commits
```bash
$ git push <--set-upstream or -u> origin main
```

### Force-push local repository to git
```bash
$ git push <-f or --force>
```

**e.g.:** after git reset and a commit on top

### Force-push local repository (lease)
```bash
$ git push --force-with-lease
```

**Notes:**

- Overwrites the remote repository's timeline, but only if no changes are lost in the process.

---
## Pull

### Fetch updates from the remote repository to the local machine
```bash
$ git pull
```

**Notes:**

- If used `--rebase` local commits are written on top of the pull content.

---
## Cloning

### Clone a Github repository
```bash
$ git clone <github_repository_url>
```

---
## References

### Show which versions have been added so far
```bash
$ git reflog
```
---
## Cleaning

### Remove untracked files from the working directory
```bash
$ git clean <-f>
```

---
## Branches, Checkout, and Switch

### Show available branches at the moment
```bash
$ git branch <--list, assumed as default>
```

### Create a new branch
```bash
$ git branch <new_branch_name> 
$ git checkout -b <new_branch_name>
$ git switch -c <new_branch_name>
```

### Delete a local branch
```bash
$ git branch -d <branch_name>
```

### Delete a remote branch
```bash
$ git push --delete origin <branch_name>
```

### Rename a local branch
```bash
$ git branch -m <old_name> <new_name> # if not on the desired branch
$ git branch -m <new_name> # if on the desired branch
```

**Notes:**

- To "rename" a remote branch, deleting it from the server, renaming it locally, and pushing it again, use:

```bash
$ git push --delete origin <old_name>
$ git branch -m <new_name>
$ git push -u origin <new_name>
```

### Switch to another branch or commit
```bash
$ git checkout <branch_name / hash> or <tag_name>
$ git switch <branch_name> or <tag_name>
```

### Return to the previous branch, after switching with Switch
```bash
$ git switch -
```

### Revert files to their last committed version
```bash
$ git checkout <"file" / .>
```

---
## Fetch

### Fetches information such as commits, branches, and tags from the remote repository
```bash
$ git fetch
```

**Notes:**

- Unlike `$ git pull`, it brings information from the remote server without merging (`$ git merge`) it into our local branch, allowing us to inspect the content it fetched.

### Fetches information about a branch from the remote server and stores it locally
```bash
$ git fetch origin <branch_name>
```

**Notes:**

- Thus, the branch becomes available in `$ git branch -a`, and if accessed with `$ git checkout <branch_name>`, a local branch with information from the server will be created.

---
## Cherry-Pick

### Picks a specific commit from one branch to another without having to wait for the task to be completed to perform the entire merge
```bash
$ git cherry-pick <commit_hash>
```

---
## Bisect

### Initiates the process to find where a problem "started," in situations where there are many commits
```bash
$ git bisect start
```

### After initiating the procedure, we must inform the good and bad commits
```bash
$ git bisect good <commit_hash>
$ git bisect bad <commit_hash>
```

### When the search process is finished, we can end the bisect with
```bash
$ git bisect reset
```

**Notes:**

- Git bisect will inform a commit back, after we input the good and bad commits. After that, we must check out this commit and respond as "git bisect good" or "git bisect bad," and follow the procedure.

---
## Rebase

### Changes the base of a branch, brings changes from another branch
```bash
$ git rebase <branch_name: main>
```

**Notes:**

- Used in cases where the develop branch is behind, for example, one commit from the main branch.

### In case of conflict during rebase, to abort
```bash
$ git rebase --abort
```

### After resolving a possible conflict in the text editor, we can continue the rebase process with
```bash
$ git rebase --continue 
```

### Merges changes made in more than one commit interactively
```bash
$ git rebase --interactive <HEAD~N> # N = number of commits
```
**example:** to merge the last 3 commits into one, we can pass N = 3, and select "squash" on 2 commits, keep one as "pick", and finally pass the resulting commit message

**Notes:**

- Rebase is not recommended to be used on public branches, accessed by other people, as it alters the project timeline, creates new (overwrites) commits.
- After Rebase, merging between branches does not create a "merge commit".

---
## Tags

### Lists all tags in the project
```bash
$ git tag <-l or --list, assumed as default>
```

### Lists tags with their messages
```bash
$ git tag -n
```

**Notes:**

- If the tag is lightweight, it shows the commit message.

### Creates a tag on the current commit
```bash
$ git tag <tag_name>
```

### Creates an "annotated" tag on the current commit
```bash
$ git tag -a -m <"message"> <annotated_tag_name>
```

**Notes:**

- Annotated = carries message and "tagger" with it.

### Creates a tag on a specific commit
```bash
$ git tag <tag_name> <commit_hash>
$ git tag -a -m <"message"> <annotated_tag_name> <commit_hash>
```

### After tagging, you can view its information with
```bash
$ git show <tag_name>
```

### Pushes an individual tag to the remote repository
```bash
$ git push origin <tag_name>
```

### Pushes all tags from the local repository to the remote (not recommended)
```bash
$ git push --tags
```

### Removes a tag locally
```bash
$ git tag -d <tag_name>
```

### Removes a tag from the remote repository
```bash
$ git push --delete origin <tag_name>
```

---
## Stash

### Saves tracked changes in memory without needing to commit
```bash
$ git stash
```

### Lists saved changes in the stash
```bash
$ git stash list
```

### Applies a saved change from the stash
```bash
$ git stash apply <stash@{number}> # number <default = 0> is the position of the stash in the list
```

### Applies a saved change from the stash and removes it afterward
```bash
$ git stash pop <stash@{number}> # number <default = 0> is the position of the stash in the list
```

### Removes a saved change from the stash
```bash
$ git stash drop <stash@{number}> # number <default = 0> is the position of the stash in the list
```

### Creates a branch from the saved stash
```bash
$ git stash branch <branch_name> <stash@{number}> # number <default = 0> is the position of the stash in the list
```

---
## Revert

### Reverts a commit
```bash
$ git revert <commit_hash_or_commit_pointer>
```

---
## Reset

### Resets files to a given version (commit), ignoring local changes
```bash
$ git reset --hard <commit_hash_or_commit_pointer> # default = HEAD
```

### Erases one or more commits from the working area
```bash
$ git reset <--hard / --mixed / --soft> <HEAD~N> # N = number of commits to go back
```

**Notes:**

- Use `--hard` for ignore local changes.
- Use `--mixed` to keep file modifications.
- Use `--soft` to keep modifications in the staging area.

---
## Extras

### Merges changes from a development branch to a main one
```bash
$ git switch main
$ git merge <development_branch_name>
$ git push
```

### In case of conflict during merge, to abort
```bash
$ git merge --abort
```

### Create a .gitignore file to ignore files/directories in version control
```bash
$ touch .gitignore
```

---
## Graphic tools for Git usage

- [Sourcetree](https://www.sourcetreeapp.com)
- [GitKraken](https://www.gitkraken.com)