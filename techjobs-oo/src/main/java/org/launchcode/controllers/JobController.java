package org.launchcode.controllers;

import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Cat
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
      model.addAttribute("job", jobData.findByID(id));

      return "job-detail";

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

        if(error.hasErrors()){
            return "new-job";
        }

        model.addAttribute("jobForm", jobForm);

        newJob.setName(jobForm.getName());
        newJob.setEmployer(jobData.getemployers().findById(jobForm.getEmployerId)());
        newJob.setLocation(jobData.getlocations().findById(jobForm.getLocationId()));
        newJob.setCoreCompetencies(jobData.getcoreCompetencies().findById(jobForm.getCoreCompetencyId()));
        newJob.setPositionType(jobData.get[ositionTypes().findById(jobForm.getPoistionTypeId()));

        jobData.add(newJob);
        return "redirect:?id=" + newJob.getId();

    }
}
