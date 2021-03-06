# AntiCopyPaster

AntiCopyPaster is a plugin for IntelliJ IDEA that tracks the copying and pasting carried out by the developer and suggests extracting duplicates into a new method as soon as they are introduced in the code.

### How to install

AntiCopyPaster requires IntelliJ IDEA of version 2020.3 or higher to work. To install the plugin:

1. Download the pre-built version of the plugin from [here](https://drive.google.com/file/d/1nmIt3XG3acsogS5iXvGxdD6Hp76dQ5V9/view?usp=sharing); 
2. Go to `File`/`Settings`/`Plugins`;
3. Select the gear icon, and choose `Install Plugin from Disk...`;
4. Choose the downloaded ZIP archive;
5. Click `Apply`;
6. Restart the IDE.

### How it works

The plugin monitors the copying and pasting that takes place inside the IDE. As soon as a code fragment is pasted, the plugin calculates a set of code metrics for it, and a pre-installed Random Forest model makes a decision whether this piece of code is suitable for `Extract Method` refactoring. If it is, the suggestion is placed in a queue, and if the duplicates are still present after a delay, the plugin suggests the developer to perform the `Extract Method` refactoring and applies the refactoring if necessary.

The scripts and tools that were used for data gathering and model training could be found [here](https://github.com/JetBrains-Research/extract-method-experiments).

### Demonstration video

We have a [demonstration video](https://youtu.be/SmPbq1BJqxE) that describes how the Random Forest model was built and how the plugin operates in the IDE.

## Contacts

If you have any questions or propositions, do not hesitate to contact Yaroslav Goluev at yaroslav.golubev@jetbrains.com.
