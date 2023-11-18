package team.tjusw.elmboot.mapper;

import team.tjusw.elmboot.domain.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransactionMapper {
	
	@Select("select * from transaction where entryWalletId=#{walletId} or expendWalletId=#{walletId} order by transactionDate desc")
	public List<Transaction> getTransactionByWalletId(Integer walletId);
	
	@Insert("insert into transaction values (null, #{transactionDate},#{transactionAmount},#{transactionType},#{entryWalletId},#{expendWalletId})")
	public int insertTransaction(Transaction transaction);

}
