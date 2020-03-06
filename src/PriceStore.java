
public class PriceStore {

	private Integer price = 0;
	private ReadWriteLock lock = new ReadWriteLock();

	public Integer getPrice() {
		Integer price = 0;
		try {
			lock.lockRead();
			price = this.price;
			lock.unlockRead();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return price;
	}

	public void setPrice(Integer price) {
		try {
			lock.lockWrite();
			this.price = price;
			lock.unlockWrite();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
