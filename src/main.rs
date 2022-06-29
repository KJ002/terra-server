use tokio;
use tokio::net::TcpListener;
use tokio::net::TcpStream;

use std::io;

async fn process_socket(socket: TcpStream) -> io::Result<()> {
    socket.readable().await?;

    let mut buffer: [u8; 1024] = [0; 1024];
    let bytes_read = socket.try_read(&mut buffer)?;

    println!("{:?}", &buffer[..=bytes_read]);

    socket.writable().await?;

    Ok(())
}

#[tokio::main]
async fn main() -> io::Result<()> {
    let listener = TcpListener::bind("127.0.0.1:2345").await?;

    loop {
        let (socket, _) = listener.accept().await?;
        process_socket(socket).await?;
    }
}
