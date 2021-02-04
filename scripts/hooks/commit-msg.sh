#!/usr/bin/env bash

# regex to validate in commit msg
commit_regex="(^(chore|docs|feat|fix|refactor|style|test|build|ci|revert|pref)\:) \[([A-z0-9_-]+)+\] \#((\d+)|(N\/A)) +"
error_msg="Aborting commit. Your commit message format invalid.Please follow the format as follows:"

if ! grep -iqE "$commit_regex" "$1"; then
  echo "Aborting commit. Your commit message format invalid.Please follow the format as follows:"
  echo "chore|docs|feat|fix|refactor|style|test|build|ci|revert|pref: [module name] #jira_issue_code your_commit_message."
  echo "Verb list:"
  echo "------------------------------------------------------------------------------------"
  echo "feat:new feature for the user, not a new feature for build script"
  echo "------------------------------------------------------------------------------------"
  echo "fix:bug fix for the user, not a fix to a build script"
  echo "------------------------------------------------------------------------------------"
  echo "refactor:refactoring production code e.g. renaming a variable"
  echo "------------------------------------------------------------------------------------"
  echo "test:adding missing tests, refactoring tests, no production code change"
  echo "------------------------------------------------------------------------------------"
  echo "chore:other changes that don't modify src or test files"
  echo "------------------------------------------------------------------------------------"
  echo "style:changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"
  echo "------------------------------------------------------------------------------------"
  echo "docs:changes to the documentation, comment etc."
  echo "------------------------------------------------------------------------------------"
  echo "pref:a code change that improves performance"
  echo "------------------------------------------------------------------------------------"
  echo "build:changes that affect the build system or external dependencies"
  echo "------------------------------------------------------------------------------------"
  echo "ci:changes to our CI configuration files and scripts"
  echo "------------------------------------------------------------------------------------"
  echo "revert:reverts a previous commit"
  echo "------------------------------------------------------------------------------------"
  exit 1
fi

#
#if !$COMMIT_FORMAT_REGEX.match(message)
#  puts COMMIT_ERROR_BANNER
#  puts "#{COMMIT_FORMAT_POLICY_TAG} Commit message format invalid. Please follow the format as follows:"
#  puts "chore|docs|feat|fix|refactor|style|test|build|ci|revert|pref: [module name] #jira_issue_code your_commit_message."
#  puts "E.g."
#  puts "fix: [app] #OTAS-1234 error message not displaying correctly when WIP creation failed."
#  puts "Or:"
#  puts "fix: [app] #N/A publish the correct version of accessory import template."
#  puts "Verb list:"
#  puts "  feat     - new feature for the user, not a new feature for build script"
#  puts "  fix      - bug fix for the user, not a fix to a build script"
#  puts "  refactor - refactoring production code e.g. renaming a variable"
#  puts "  test     - adding missing tests, refactoring tests, no production code change"
#  puts "  chore    - other changes that don't modify src or test files"
#  puts "  style    - changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"
#  puts "  docs     - changes to the documentation, comment etc."
#  puts "  pref     - a code change that improves performance"
#  puts "  build    - changes that affect the build system or external dependencies"
#  puts "  ci       - changes to our CI configuration files and scripts"
#  puts "  revert   - reverts a previous commit"
#  puts COMMIT_ERROR_BANNER
#  exit 1
#end
