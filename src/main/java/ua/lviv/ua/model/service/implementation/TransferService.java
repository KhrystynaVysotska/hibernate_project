package ua.lviv.ua.model.service.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.lviv.ua.model.dao.DataAccess;
import ua.lviv.ua.model.dao.implementation.TransferDataAccess;
import ua.lviv.ua.model.entity.AccountEntity;
import ua.lviv.ua.model.entity.TransferEntity;
import ua.lviv.ua.model.service.AbstractService;
import ua.lviv.ua.utils.HibernateUtil;

public class TransferService extends AbstractService<TransferEntity> {
	private TransferDataAccess transferDataAccess = new TransferDataAccess();

	@Override
	protected DataAccess<TransferEntity> getDao() {
		return transferDataAccess;
	}

	public TransferEntity makeTransaction(TransferEntity transfer) {
		Session session = null;
		Transaction transaction = null;
		AccountEntity sender = transfer.getAccountBySenderAccountId();
		AccountEntity recipient = transfer.getAccountByRecipientAccountId();
		Integer amountToTransfer = transfer.getAmount();
		if (sender.getAmount() < amountToTransfer) {
			System.out.println("[WARN] You don't have enough money to make this transfer");
			return null;
		} else if (recipient.equals(sender)) {
			System.out.println("[WARN] You cannot transfer money to the same account!");
			return null;
		} else {
			try {
				session = new HibernateUtil().getSession();
				transaction = session.beginTransaction();
				sender.setAmount(sender.getAmount() - amountToTransfer);
				recipient.setAmount(recipient.getAmount() + amountToTransfer);
				new AccountService().update(sender);
				new AccountService().update(recipient);
				create(transfer);
				transaction.commit();
			} catch (Exception ex) {
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				new HibernateUtil().closeSession(session);
			}
		}
		return transfer;
	}

}
