timeout(5) {
  node("master") {
    tools {
    git 'Default'
  }
    stage("Code Check Out") {
      git branch: 'main', credentialsId: '4e0277b8-19db-4af6-b11d-c6e776ee7fbb', url: 'https://github.com/fsawscoe/ReactApplication.git'
      echo("${GIT_URL} Repository was successfully cloned.")
    }
	
    stage("Build Node Modules") {
      sh("npm install")
      echo("Node Modules installed successully")
    }
	
    stage("Build/Package the React Application") {
      sh("npm run build")
      echo("React Application is Built Successfully")
    }

}

  }
}
