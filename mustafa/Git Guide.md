# Git Guide and Basic Commands

Firstly, i’ve done the configuration of **user.name** and **user.email** by executing the following commands:
```
git config -global user.name ‘Mustafa Sarac’
git config —global user.email ‘saracmustafa95@gmail.com’
```

Then, i created a new repository on my GitHub account. By **HTTPS URL** of this repository, i’ve copied the repository to my Local computer. In order to do that, i’ve used the following command line:
```
git clone https://github.com/srcmustafa/Graph-Project.git
```

After that, i’ve copied one of my Java project into that ‘Graph-Project’ folder. Then, i’ve reinitialized this existing repository by the following command line:
```
git init
```

and in order to add the whole Java project to the **staging area**, used this command line:
```
git add .
```

After that, i’ve committed these files by this command line:
```
git commit -m ‘The initial version of my Graph Project is committed.’
```

and the whole project has been moved from the staging area, into the local repository. At this point our file is still at local repository, not at remote repository on GitHub yet.

Finally, in order to update the remote repository on GitHub account, i’ve pushed them by this command line:
```
git push origin master
```

and it wrote these objects to the GitHub account.

In addition to these, __Mehmet__ sent me a permission to collaborate on his example project. I’ve cloned his project and copied it to my local computer. Then, he has updated some of the files in his GitHub repository.

Then, i’ve tried to pull the updated version of this project by the following command line:
```
git pull
```

__Additionally, some other basic Git commands__:
```
git log = Showing all commits
git fetch = Downloading all changes from remote repository, but do not merge into HEAD.
git merge = Merging into the HEAD.
```
