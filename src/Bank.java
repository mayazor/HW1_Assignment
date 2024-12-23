import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
        System.out.println("Account " + account.GetAccountNumber() + " opened successfully.");
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToClose = null;
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    accountToClose = account;
                    System.out.println("Account " + accountNumber + " closed successfully.");
                } else {
                    System.out.println("Cannot close account " + accountNumber + " because it is in debt.");
                }
            }
        }
        if (accountToClose != null) {
            accounts.remove(accountToClose);
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}
