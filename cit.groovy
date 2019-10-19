node("master"){
    wrks = env.WORKSPACE
    stage("Prepare"){
        println("Preparing the workspace...")
        git(
            url: "git@github.com:jayabalandevops/homepls.git",
            branch: "master"
        )
        dir('config'){
            url: "git@github.com:jayabalandevops/homeconf.git",
            branch: "master"
        }
        println("Prepared the workspace.")
    }
}