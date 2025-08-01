package org.orcid.core.manager.v3.read_only;

import java.util.List;

import org.orcid.jaxb.model.v3.release.record.ExternalIDs;
import org.orcid.jaxb.model.v3.release.record.Work;
import org.orcid.jaxb.model.v3.release.record.WorkBulk;
import org.orcid.jaxb.model.v3.release.record.summary.WorkSummary;
import org.orcid.jaxb.model.v3.release.record.summary.Works;
import org.orcid.persistence.jpa.entities.WorkLastModifiedEntity;
import org.orcid.pojo.WorkExtended;
import org.orcid.pojo.WorkSummaryExtended;
import org.orcid.pojo.WorksExtended;
import org.orcid.pojo.ajaxForm.WorkForm;

public interface WorkManagerReadOnly extends ManagerReadOnlyBase {           
    /**
     * Find the works for a specific user
     * 
     * @param orcid
     * 		the Id of the user
     * @return the list of works associated to the specific user 
     * */
    List<Work> findWorks(String orcid); 
    
    /**
     * Find the public works for a specific user
     * 
     * @param orcid
     * 		the Id of the user
     * @return the list of works associated to the specific user 
     * */
    List<Work> findPublicWorks(String orcid);
    
    /**
     * Checks if there is any public work for a specific user
     * 
     * @param orcid
     *          the Id of the user
     * @return true if there is at least one public work for a specific user
     * */
    Boolean hasPublicWorks(String orcid);
    
    /**
     * Get the given Work from the database
     * @param orcid
     *          The work owner
     * @param workId
     *          The work id             
     * */
    Work getWork(String orcid, Long workId);
    
    WorkSummary getWorkSummary(String orcid, Long workId);
    
    /**
     * Get the list of works that belongs to a user
     * 
     * @param orcid
     * @return the list of works that belongs to this user
     * */
    List<WorkSummary> getWorksSummaryList(String orcid);

    /**
     * Get the list of works that belongs to a user
     *
     * @param orcid
     * @param featuredOnly
     * @return the list of works that belongs to this user
     * */
    List<WorkSummaryExtended> getWorksSummaryExtendedList(String orcid, boolean featuredOnly);

    /**
     * Generate a grouped list of works with the given list of works
     * 
     * @param works
     *          The list of works to group
     * @param justPublic
     *          Specify if we want to group only the public elements in the given list
     * @return Works element with the WorkSummary elements grouped                  
     * */
    Works groupWorks(List<WorkSummary> works, boolean justPublic);

    /**
     * Returns a WorkBulk object containing a list of specified works.
     * 
     * @param orcid
     * @param putCodesAsString of required works
     * @return WorkBulk element containing the specified works
     */
    WorkBulk findWorkBulk(String orcid, String putCodesAsString);
    
    /**
     * Returns a org.orcid.jaxb.model.v3.release.record.summary.Works object containing grouped WorkSummary objects for the given user.
     * @param orcid
     * @return org.orcid.jaxb.model.v3.release.record.summary.Works object
     */
    Works getWorksAsGroups(String orcid);

    /**
     * Returns a org.orcid.jaxb.model.v3.release.record.summary.Works object containing grouped WorkSummary objects for the given user.
     * @param orcid
     * @return WorksExtended object
     */
    WorksExtended getWorksExtendedAsGroups(String orcid);

    /**
     * Returns a org.orcid.jaxb.model.v3.release.record.summary.Works object containing grouped WorkSummary objects of featured works for the given user.
     * @param orcid
     * @return WorksExtended object
     */
    List<WorkSummaryExtended> getFeaturedWorksSummaryExtended(String orcid);

    List<WorkForm> getFeaturedWorks(String orcid);

    /**
     * Returns a list of works that matches the given list of WorkLastModifiedEntity entities
     * @param elements
     * @return a list of Work elements 
     * */
    List<Work> findWorks(String orcid, List<WorkLastModifiedEntity> elements);

    List<WorkSummary> getWorksSummaryList(String orcid, List<Long> putCodes);
    
    /** 
     * Returns a list of ALL external ids for this ORCID
     * @param orcid
     * @return a compiled ExternalIDs object
     */
    ExternalIDs getAllExternalIDs(String orcid);

    Works groupWorksAndGenerateGroupingSuggestions(List<WorkSummary> summaries, String orcid);

    WorksExtended groupWorksExtendedAndGenerateGroupingSuggestions(List<WorkSummaryExtended> summaries, String orcid);

    WorkExtended getWorkExtended(String orcid, Long workId);
}
