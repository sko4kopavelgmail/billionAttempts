package skp.billionAttempts.service.implemetation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skp.billionAttempts.repository.education.*;

@Service
@Slf4j
public class CompetencyService {

    private CompetencyRepository competencyRepository;

    private CompetencyResultRepository competencyResultRepository;

    private FullCompetencyRepository fullCompetencyRepository;

    private StudySubjectRepository studySubjectRepository;

    private WorkProgrammeRepository workProgrammeRepository;

    @Autowired
    public CompetencyService(CompetencyRepository competencyRepository,
                             CompetencyResultRepository competencyResultRepository,
                             FullCompetencyRepository fullCompetencyRepository,
                             StudySubjectRepository studySubjectRepository,
                             WorkProgrammeRepository workProgrammeRepository) {
        this.competencyRepository = competencyRepository;
        this.competencyResultRepository = competencyResultRepository;
        this.fullCompetencyRepository = fullCompetencyRepository;
        this.studySubjectRepository = studySubjectRepository;
        this.workProgrammeRepository = workProgrammeRepository;
    }



}
