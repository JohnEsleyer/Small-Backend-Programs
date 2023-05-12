
### Serve Images with FastAPI
A small FastAPI application that serves all images in the "images" folder to the web.

##### How to run
Start the server
```
uvicorn main:app --reload
```

Endpoints:
GET - localhost:8000/images to get all images.
GET - localhost:8000/images/{filename} to get a single image by file name.

