db = {
    'user'     : 'mjc',
    'password' : 'mjc',
    'host'     : '127.0.0.1',
    'port'     : '3306',
    'database' : 'park'
}

DB_URL = f"mysql+mysqlconnector://{db['user']}:{db['password']}@{db['host']}:{db['port']}/{db['database']}?charset=utf8"