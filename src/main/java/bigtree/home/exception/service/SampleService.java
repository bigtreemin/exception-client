package bigtree.home.exception.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import bigtree.home.exception.ex.SampleExceptionRuntimeException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {

    public String getSampleData() {
        log.debug("Start SampleService ");
        throw new SampleExceptionRuntimeException(SampleExceptionRuntimeException.VALIDATION_ERRORCODE,"getSampleData exception ...", null);
    }

    public String getSampleData(User user) {
        log.debug("Start SampleService ");
        try {
            ObjectMapper o = new ObjectMapper();
            return o.writeValueAsString(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
