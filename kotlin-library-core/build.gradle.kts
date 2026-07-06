import net.cacheoverflow.conventions.apache2License
import net.cacheoverflow.conventions.defaultDevelopers
import net.cacheoverflow.conventions.defaultPublishing
import net.cacheoverflow.conventions.extension.configureJava
import net.cacheoverflow.conventions.extension.defaultCompilerOptions
import net.cacheoverflow.conventions.extension.withJvm
import net.cacheoverflow.conventions.extension.withNative
import net.cacheoverflow.conventions.projectMetadata

plugins {
    alias(sharedLibs.plugins.kotlin.multiplatform)
    alias(sharedLibs.plugins.mavenPublish)
    alias(sharedLibs.plugins.conventions)
    `maven-publish`
}

configureJava(sharedLibs.versions.jvmTarget.get().toInt())
defaultPublishing {
    publications.withType<MavenPublication>().configureEach {
        pom {
            defaultDevelopers()
            apache2License()
            projectMetadata(
                name = project.name,
                description = property("project.description") as String,
                repository = property("project.repository") as String
            )
        }
    }
}

kotlin {
    defaultCompilerOptions()
    withNative()
    withJvm()
    applyDefaultHierarchyTemplate()
}
