pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://artifact.bytedance.com/repository/pangle")
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
        maven(url = "https://dl.cloudsmith.io/public/avatye/Android-PointHome/maven/")
        maven(url = "https://dl.cloudsmith.io/public/avatye/android-adcash/maven/")
        maven(url = "https://nexus.wisernd.co.kr/repository/sdk/")

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cauly/Android-SDK/SDK")
            credentials {
                username = "cauly"
                password = "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"
            }
        }
    }
}

rootProject.name = "sample"
include(":app")
 