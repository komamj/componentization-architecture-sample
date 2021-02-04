#!/usr/bin/env bash

GIT_DIR=$(git rev-parse --git-dir)

echo "Installing git hooks..."
echo "Installing commit-msg hook..."
rm "$GIT_DIR"/hooks/commit-msg
# this command creates symlink to our commit-msg script
ln -s ../../scripts/hooks/commit-msg.sh "$GIT_DIR"/hooks/commit-msg
chmod +x "$GIT_DIR"/hooks/commit-msg
echo "Installing commit-msg Done!"

echo "Installing pre-push hook..."
rm "$GIT_DIR"/hooks/pre-push
# this command creates symlink to our pre-push script
ln -s ../../scripts/hooks/pre-push.sh "$GIT_DIR"/hooks/pre-push
chmod +x "$GIT_DIR"/hooks/pre-push
echo "Installing pre-push hook Done!"
