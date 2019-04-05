@Entity
public class StatsCandidacyJPA {
    @Id
    @GeneratedValue
    public Long id;
    @ManyToOne
    public CandidacyJPA candidacy;
    public int answered;
    public int rights;
    public static StatsCandidacyJPA build(CandidacyJPA candidacyJPA) {
        StatsCandidacyJPA statsCandidacyJPA = new StatsCandidacyJPA();
        statsCandidacyJPA.candidacy = candidacyJPA;
        statsCandidacyJPA.answered = 0;
        statsCandidacyJPA.rights = 0;
        JpaUtil.save(statsCandidacyJPA);
        return statsCandidacyJPA;
    }
}