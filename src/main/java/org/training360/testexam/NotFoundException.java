package org.training360.testexam;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {

    public NotFoundException(Long id){
        super(
                URI.create("teams/not_found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Not found with id '%d'", id));
    }
}
