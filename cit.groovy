node("$NodeName"){
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
    stage("Build"){
        println("Building the ARA app...")
        load 'app/build.groovy'
        println("Built the ARA app.")
    }
    stage("Deploy"){
        println("Deploying the ARA app...")
        sh "chmod +x scripts/dep.sh"
        sh "scripts/dep.sh"
        println("Deployed the ARA app.")
    }
}