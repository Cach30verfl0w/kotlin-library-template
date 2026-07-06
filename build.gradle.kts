val projectGroup = requireNotNull(property("project.group") as? String) { "Unable to find project.group" }
val projectVersion = libs.versions.project.get()

allprojects {
    group = projectGroup
    version = projectVersion
}
