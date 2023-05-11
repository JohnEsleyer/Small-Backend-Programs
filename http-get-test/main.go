package main

import (
	"github.com/gin-gonic/gin"
)

func main() {
	// Create new instance of the Gin router
	router := gin.Default()

	// Define a route for the root endpoint
	router.GET("/", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "Hello World",
		})
	})

	// Start the server
	router.Run()
}
