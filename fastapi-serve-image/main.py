from fastapi import FastAPI
from fastapi.responses import FileResponse
import os

app = FastAPI()

@app.get("/images/{filename}")
async def get_image(filename: str):
    # Check if the file exists in the "images" folder
    if os.path.isfile(f"images/{filename}"):
        # Serve the file as a response
        return FileResponse(f"images/{filename}", media_type="image/jpeg")
    else:
        # Return a 404 error if the file doesn't exist
        return {"error": "File not found"}

@app.get("/images")
async def get_all_images():
    # Get a list of all files in the "images" folder
    files = os.listdir("images")
    # Filter the list to only include image files
    image_files = [f for f in files if f.endswith(".jpg") or f.endswith(".jpeg") or f.endswith(".png")]
    # Serve the list as a response
    return {"images": image_files}