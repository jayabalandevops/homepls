node("master"){
    wrks = env.WORKSPACE
    stage("Prepare"){
        println("Preparing the workspace...")
        git(
            url: "git@github.com:jayabalandevops/homepls.git",
            branch: "master"
        )
        dir('config'){
            git(
              url: "git@github.com:jayabalandevops/homeconf.git",
              branch: "master"
            )
        }
        println("Prepared the workspace.")
    }
    stage("CloningARApp"){
        println("Cloning the ARA app...")
        load 'app/clone.groovy'
        println("Cloned the ARA app.")
    }
}