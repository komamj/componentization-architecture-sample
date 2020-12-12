# componentization-architecture-sample
The componentization architecture sample app.

## Git Subtree 的步骤

### 初始化子项目 Subtree

cd 到当前项目的路径
git remote add `short name` `url` （为远程仓库设置别名简写）
git subtree add --prefix=`子项目相对路径` `short name` `分支`

### 提交更改到子项目的 git 服务器

cd 到当前项目的路径
git subtree push --prefix=`子项目相对路径` `short name` `分支`

### 更新子项目新的代码到父项目

git subtree pull --prefix=`子项目相对路径` `short name` `分支`
