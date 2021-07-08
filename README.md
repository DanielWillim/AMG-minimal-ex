# Introduction 

<!-- Plugin description -->
This plugin will parse a JSON file with a JSON object as root and generate an incoming message and big query schema files 
in the location specified by `util.Settings.kt`.
<!-- Plugin description end -->

# Getting Started
1. Clone and open repo in Intellij.
2. Run gradle task `runIde`, this will open an Intellij sandbox with the plugin installed
3. Open convergence repo
4. Run tool through `Tools -> Generate Mapper from JSON`

# Build and Test

## Please note
* If building and testing for Intellij-platform version 2020.* an older version of the kotlin plugin will be used. This version has known memory leek issues that the compiler will warn for when building the plugin. Change targeted version in `gradle.properties`