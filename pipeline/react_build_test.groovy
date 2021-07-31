timeout(5) {
  node("master") {
    stage("Code Check Out") {
      sh("git clone ${GIT_URL}")
      echo("${GIT_URL} Repository was successfully cloned.")
    }
	
    stage("Build Node Modules") {
      sh("npm install")
      echo("Node Modules installed successully")
    }
    
    stage("Run Tests For React Application") {
      sh("npm test")
      echo("Test Phase Completed successfully")
    }    
	
    stage("Build/Package the React Application") {
      sh("npm run build")
      echo("React Application is Built Successfully")
    }
	
  }
}
