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
sql = "DROP TABLE `student`;"
cur.execute(sql)
con.commit()
con.close()