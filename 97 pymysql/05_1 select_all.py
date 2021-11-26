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
sql = "SELECT * FROM `student`"
cur.execute(sql)
rows = cur.fetchall()

for row in rows:
    print(row)

con.close()