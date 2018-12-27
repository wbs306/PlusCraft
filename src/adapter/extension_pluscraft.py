# noinspection PyInterpreter
import time, threading, subprocess, socket
from scratch3_adapter import settings
from scratch3_adapter.core_extension import Extension

class PlusCraftExtension(Extension):
    def __init__(self):
        name = type(self).__name__
        super().__init__(name)

    def run(self):
        server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server.bind(("localhost", 2333))
        server.listen(5)
        self.logger.info("Socket server is running")
        is_conn = False
        while self._running:
            if not is_conn:
                conn, addr = server.accept()
                self.logger.info("Get client")
                self.logger.info(addr)
                is_conn = True
            data = conn.recv(1024)
            mesg = str(data, 'UTF-8')
            self.logger.info(mesg)
            if mesg == "quit":
                conn.close()
                is_conn = False
            else:
                conn.send(b"OK\n")
                message = {'message':mesg, 'topic':'eim'}
                self.publish(message)
        time.sleep(1)
                
export = PlusCraftExtension

