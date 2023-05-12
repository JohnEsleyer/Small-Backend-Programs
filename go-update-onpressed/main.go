// main.go
package main

import (
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/", serveStatic)
	http.HandleFunc("/button-press", handleButtonPress)
	http.ListenAndServe(":8080", nil)
}

func serveStatic(w http.ResponseWriter, r *http.Request) {
	// Serve the static HTML file
	http.ServeFile(w, r, "index.html")
}

func handleButtonPress(w http.ResponseWriter, r *http.Request) {
	// Print "Pressed" to the console
	fmt.Println("Pressed!")
}
