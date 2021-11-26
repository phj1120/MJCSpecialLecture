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
CREATE TABLE IF NOT EXISTS `student` (
`ID` INT(11) PRIMARY KEY AUTO_INCREMENT,
`NAME` VARCHAR(10) NOT NULL,
`AGE` VARCHAR(10) NOT NULL
);
"""

cur.execute(sql)
con.commit()
con.close()