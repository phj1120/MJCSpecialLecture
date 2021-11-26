import time
import pymysql

con = pymysql.connect(
    user="root",
    passwd="root",
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
# datetime = time.strftime("%Y%m%d%H%M%S", time.localtime(time.time()))
# cur.execute(sql, ("36.5", "NORMAL", datetime))
cur.execute(sql, ("박현준", "24"))
cur.execute(sql, ("김도희", "23"))
con.commit()
con.close()