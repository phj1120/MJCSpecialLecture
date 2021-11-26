# set FLASK_APP = main 윈도우
#  FLASK_APP = main 윈도우

# flask run
import numpy as np
from flask import Flask, render_template, jsonify, request
from sqlalchemy import create_engine, text

app = Flask(__name__)

@app.route("/first")
def index():
    return render_template("index.html")

@app.route("/test", methods=["POST"])
def inference():

    return jsonify(
        myname = "phj"
    )


if __name__ == "__main__":
    app.run(host='0.0.0.0', debug=True)