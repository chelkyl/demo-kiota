# Kiota demo reports

## General process

1. Create workspace: `GIT_BRANCH_PREFIX=... ./work branch-name`
2. Create tests: `create /uri1 /uri2`
3. Run tests: `run -m main -l typescript`
4. Prep reports: `prep -n -tascii -ltypescript -lpython -r -d report_header.md -o README.md`
