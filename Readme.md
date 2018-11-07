Quick setup — if you’ve done this kind of thing before
or	
HTTPS
SSH

git@github.com:catlvsuger/Java-Coding.git
Get started by creating a new file or uploading an existing file. We recommend every repository include a README, LICENSE, and .gitignore.

…or create a new repository on the command line
echo "# Java-Coding" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:catlvsuger/Java-Coding.git
git push -u origin master

…or push an existing repository from the command line
git remote add origin git@github.com:catlvsuger/Java-Coding.git
git push -u origin master

…or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.

> error ： fatal: refusing to merge unrelated histories
解决：先pull，因为两个仓库不同，发现refusing to merge unrelated histories，无法pull
因为他们是两个不同的项目，要把两个不同的项目合并，git需要添加一句代码，在git pull，
这句代码是在git 2.9.2版本发生的，最新的版本需要添加--allow-unrelated-histories
git pull origin master --allow-unrelated-histories

> error: failed to push some refs to 'git@github.com:....." Updates were rejected because the remote contains work that you do not have locally.
This is usually caused by another repository pushing to
解决：1、先拉下来，会自动合并的（不用操心）
git pull origin master
2、再上传
git push -u origin master


> error: Pull is not possible because you have unmerged files.
解决：将本地的冲突文件冲掉，不仅需要reset到MERGE-HEAD或者HEAD,还需要--hard。没有后面的hard，不会冲掉本地工作区。只会冲掉stage区。
git reset --hard FETCH_HEAD
