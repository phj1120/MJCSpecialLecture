import time
import pymysql

con = pymysql.connect(
    user="mjc",
    passwd="mjc",
    host="localhost",
    port=3306,
    db="park",
    charset="utf8"
)


cur = con.cursor(pymysql.cursors.DictCursor)
sql = """
INSERT INTO `student` 
(NAME, AGE)
VALUES
(%s, %s);
"""
values = [
    ("이태형", "24"),
    ("김준재", "24"),
    ("박세정", "24"),
    ("조서연", "21")
]
cur.executemany(sql, values)
con.commit()
con.close()