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
        maven(url = "https://artifact.bytedance.com/repository/pangle")
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
        maven(url = "https://dl.cloudsmith.io/public/avatye/Android-CashBlock/maven/")
        maven(url = "https://dl.cloudsmith.io/public/avatye/Android-PointHome/maven/")
        maven(url = "https://dl.cloudsmith.io/public/avatye/android-pointhome-internal/maven/")


        maven {
            url = uri("s3://repo.cauly.net/releases")
            credentials(AwsCredentials::class.java) {
                accessKey = "AKIAWRZUK5MFKYVSUOLB"
                secretKey = "SGOr65MOJeKBUFxeVNZ4ogITUKvcltWqEApC41JL"
            }
        }
    }
}

rootProject.name = "sample"
include(":app")
 