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
sql = "DELETE FROM `student` WHERE ID = %s"
# cur.execute(sql, (6, ))

values = [
    1, 2, 3, 4, 5
]
cur.executemany(sql, values)

con.commit()
con.close()
