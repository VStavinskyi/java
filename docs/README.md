# Intro
This repository is devoted to RightScale SelfService space automation.

The basic plan is described in this [presentation](https://drive.google.com/file/d/11id9sdwA5oqJnL1GW2Lhcez10AhA6FiP/view?usp=sharing)

The main idea is to automate the process of creation CAT files and propagating those between RightScale accounts as there is no such functionality at RightScale.

![Alt text](release-pipeline.png?raw=true "Title")


Stages for implementation:
1. VSC all accounts we are managing ( Manually - done. Automation:  )
( PC Dev - done, PC Test, QAD RAD, QAD Early Adopters, PC Sandbox1, PC Sandbox2, PC Sandbox3, Training, Support)
(Bamboo job)
2. Unify all CAT files so they would match each other in different accounts. ( Undone )
( Right now we have different CAT files that are specific to each account )
3. Clean up old, depricated CAT files from accounts. ( In progress )
( To prevent depricated files propagating all over accounts we need to make some cleanup )
4. Update script to do the merges between accounts ( Done )
( This can only be done when the accounts will be ready to match each other )
5. Create Bamboo job to manage the CD for all accounts. ( In progress )
6. Review and cut admin permissions for users and give only a small group people ability to do "Hotfixes" ( Undone )
7. Integrate notification system ( Done. Emails will be released later )
8. Implement pipeline and start using it. ( Undone )

## Requirements to use the script

1. Python version is higher 3.6
2. Installed libraries:
pip install -r requirements.txt
3. Created creds file that will be used for accessing the RightScale API
you would require token and correct url as well as account ID

## How to use the script
Commands:
```bash
python3 rightscale_commands.py --help
Usage: rightscale_commands.py [OPTIONS] COMMAND [ARGS]...

Options:
  --help  Show this message and exit.

Commands:
  clean                     Delete Cat files from account
  create                    Create CAT file
  download                  By default downloads all CATs from all accounts
  download-push             Downloads and pushes to account
  filter-designer           Shows information about Designer tab
  publish                   Publish CAT file to CloudApp
  push                      Push CAT files to bitbucket
  show-dependent-templates  Shows dependent CATs that needs to recompile
                            for...
  show-detailed             Shows information about CAT file
  template-info             Get all objects from account as a json
  update                    Update cat

Examples:
python3 rightscale_commands.py download -a "Sandbox2"
python3 rightscale_commands.py update -f $file -a "Sandbox2" --force
python3 rightscale_commands.py clean -a "Sandbox2" --file $file --force

```
## Templating
For templating script templator.py was created.
It is used in bundle with variables.json and template files(they are marked with -t.rb and located at Templates folder).
Usage:
```bash
python templator.py --help
usage: templator.py [-h] [-a ACCOUNT] [-f FILE]

Render file

optional arguments:
  -h, --help            show this help message and exit
  -a ACCOUNT, --account ACCOUNT
                        Processed account
  -f FILE, --file FILE  Processed file

Examples:
python3 templator.py -a Sandbox3 -f cat_Windows_Server-t.rb
```
Templator.py script will use template file and update it with variables from variables.json based on account that was set.

Schema of CAT workflow using templates:
![Alt text](cat-workflow.png?raw=true "Templates schema")

## Issues:
- It`s not possible to download CAT files if they have same file name even though they are stored under different CAT name
