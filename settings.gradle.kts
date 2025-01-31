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
    }
}

rootProject.name = "Clean Architecture Project"

include(
    ":app",
    ":common:common-model",
    ":common:common-util",
    ":data:data-coin",
    ":di:di-stock",
    ":data:data-stock",
    ":domain:domain-coin",
    ":domain:domain-stock",
    ":di:di-coin",
    ":feature:feature-coin-list",
    ":feature:feature-coin-detail"
)
include(":common:common-test")
