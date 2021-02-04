#!/usr/bin/env bash

echo "Running pre-push hook"
./scripts/run-quality.sh

# $? stores exit value of the last command
if [ $? -ne 0 ]; then
  echo "Code quality must pass before push!"
  exit 1
fi
