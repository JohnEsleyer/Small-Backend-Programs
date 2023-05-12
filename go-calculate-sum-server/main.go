package main

import (
	"fmt"
	"html/template"
	"net/http"
	"strconv"
)

func main() {
	http.HandleFunc("/", addHandler)
	http.ListenAndServe(":8080", nil)
}

func addHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		// Parse the form data
		num1, err1 := strconv.Atoi(r.FormValue("num1"))
		num2, err2 := strconv.Atoi(r.FormValue("num2"))

		// Check for errors
		if err1 != nil || err2 != nil {
			http.Error(w, "Invalid input", http.StatusBadRequest)
			return
		}

		// Calculate the sum
		sum := num1 + num2

		// Display the result
		tmpl, err := template.New("result").Parse("<h1>{{.Num1}} + {{.Num2}} = {{.Sum}}</h1>")
		if err != nil {
			http.Error(w, "Internal server error", http.StatusInternalServerError)
			return
		}
		err = tmpl.Execute(w, struct {
			Num1 int
			Num2 int
			Sum  int
		}{num1, num2, sum})
		if err != nil {
			http.Error(w, "Internal server error", http.StatusInternalServerError)
			return
		}
		return
	}

	// Display the form to accept input
	w.Header().Set("Content-Type", "text/html")
	fmt.Fprintln(w, `
		<h1>Add two numbers</h1>
		<form method="POST">
			<label for="num1">Number 1:</label>
			<input type="number" name="num1" id="num1" required><br><br>
			<label for="num2">Number 2:</label>
			<input type="number" name="num2" id="num2" required><br><br>
			<input type="submit" value="Add">
		</form>
	`)
}
