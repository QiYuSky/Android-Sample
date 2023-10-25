pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        //default 'libs' file is imported automatically
        create("libs") {
//            from(files("./gradle/libs.versions.toml"))
        }

        //add androidX lib
        create("xLibs") {
            from(files("./gradle/x.versions.toml"))
        }
    }
}

rootProject.name = "Android-Sample"
include(":app")
 