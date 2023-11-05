package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {

    private LottoTicket lottoTicket;
    private List<Lotto> lottos;

    public void createLottoTicket(String moneyInput) {
        this.lottoTicket = new LottoTicket(moneyInput);
        this.lottos = generateLottoTickets();
    }

    public int getTicketCount() {
        return this.lottoTicket.getTicketCount();
    }

    private List<Lotto> generateLottoTickets() {
        List<Lotto> generatedLottos = new ArrayList<>();
        int lottoCount = getTicketCount();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            generatedLottos.add(new Lotto(lottoNumbers));
        }
        return generatedLottos;
    }

    private static List<Integer> generateLottoNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            uniqueNumbers.add(number);
        }
        List<Integer> lottoNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    public List<Lotto> purchaseLottoTickets() {
        return this.lottos;
    }
}