package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyProcedureComponent;
import java.util.List;
import java.util.Collections;

public class ImagingStudy30_50 {

    private static final String URN_DICOM_UID = "urn:dicom:uid";

    private static final String URN_IETF_RFC_3986 = "urn:ietf:rfc:3986";

    public static org.hl7.fhir.dstu3.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r5.model.ImagingStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy tgt = new org.hl7.fhir.dstu3.model.ImagingStudy();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) {
            if (URN_DICOM_UID.equals(t.getSystem())) {
                tgt.setUid(t.getValue());
            } else {
                tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
            }
        }
        if (src.hasStatus()) {
            org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus s = src.getStatus();
            switch(s) {
                case REGISTERED:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.OFFLINE);
                    break;
                case AVAILABLE:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.ONLINE);
                    break;
                case CANCELLED:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.UNAVAILABLE);
                    break;
                default:
                    break;
            }
        }
        for (org.hl7.fhir.r5.model.Coding t : src.getModality()) {
            tgt.addModalityList(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        }
        if (src.hasStarted()) {
            tgt.setStartedElement(VersionConvertor_30_50.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasReferrer()) {
            tgt.setReferrer(VersionConvertor_30_50.convertReference(src.getReferrer()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getInterpreter()) {
            tgt.addInterpreter(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasNumberOfSeriesElement())
            tgt.setNumberOfSeriesElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfSeriesElement()));
        if (src.hasNumberOfInstancesElement())
            tgt.setNumberOfInstancesElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfInstancesElement()));
        for (ImagingStudyProcedureComponent t : src.getProcedure()) {
            if (t.hasValueReference()) {
                tgt.addProcedureReference(VersionConvertor_30_50.convertReference(t.getValueReference()));
            } else {
                tgt.addProcedureCode(VersionConvertor_30_50.convertCodeableConcept(t.getValueCodeableConcept()));
            }
        }
        List<org.hl7.fhir.r5.model.CodeableReference> reasonCodes = src.getReason();
        if (reasonCodes.size() > 0) {
            tgt.setReason(VersionConvertor_30_50.convertCodeableConcept(reasonCodes.get(0).getConcept()));
            if (reasonCodes.size() > 1) {
            }
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
            tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu3.model.ImagingStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImagingStudy tgt = new org.hl7.fhir.r5.model.ImagingStudy();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUid()) {
            org.hl7.fhir.r5.model.Identifier i = new org.hl7.fhir.r5.model.Identifier();
            i.setSystem(URN_DICOM_UID);
            i.setValue(src.getUid());
            tgt.addIdentifier(i);
        }
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasAccession())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getAccession()));
        if (src.hasAvailability()) {
            org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability availability = src.getAvailability();
            switch(availability) {
                case OFFLINE:
                    tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
                    break;
                case UNAVAILABLE:
                    tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
                    break;
                case ONLINE:
                case NEARLINE:
                    tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
                    break;
                default:
                    break;
            }
        } else {
            tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
        }
        for (org.hl7.fhir.dstu3.model.Coding t : src.getModalityList()) {
            tgt.addModality(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasContext()) {
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        }
        if (src.hasStarted()) {
            tgt.setStartedElement(VersionConvertor_30_50.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasReferrer()) {
            tgt.setReferrer(VersionConvertor_30_50.convertReference(src.getReferrer()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getInterpreter()) {
            tgt.addInterpreter(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasNumberOfSeriesElement())
            tgt.setNumberOfSeriesElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfSeriesElement()));
        if (src.hasNumberOfInstancesElement())
            tgt.setNumberOfInstancesElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfInstancesElement()));
        List<org.hl7.fhir.dstu3.model.Reference> procedureReferences = src.getProcedureReference();
        if (procedureReferences.size() > 0) {
            tgt.addProcedure().setValue(VersionConvertor_30_50.convertReference(procedureReferences.get(0)));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getProcedureCode()) {
            tgt.addProcedure().setValue(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(src.getReason()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
            tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUidElement())
            tgt.setUidElement((org.hl7.fhir.dstu3.model.OidType) VersionConvertor_30_50.convertType(src.getUidElement()));
        if (src.hasNumberElement())
            tgt.setNumberElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberElement()));
        if (src.hasModality()) {
            tgt.setModality(VersionConvertor_30_50.convertCoding(src.getModality()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasNumberOfInstancesElement())
            tgt.setNumberOfInstancesElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfInstancesElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasBodySite()) {
            tgt.setBodySite(VersionConvertor_30_50.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            tgt.setLaterality(VersionConvertor_30_50.convertCoding(src.getLaterality()));
        }
        if (src.hasStartedElement()) {
            tgt.setStartedElement(VersionConvertor_30_50.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
            tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUidElement())
            tgt.setUidElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_30_50.convertType(src.getUidElement()));
        if (src.hasNumberElement())
            tgt.setNumberElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberElement()));
        if (src.hasModality()) {
            tgt.setModality(VersionConvertor_30_50.convertCoding(src.getModality()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasNumberOfInstancesElement())
            tgt.setNumberOfInstancesElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfInstancesElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasBodySite()) {
            tgt.setBodySite(VersionConvertor_30_50.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            tgt.setLaterality(VersionConvertor_30_50.convertCoding(src.getLaterality()));
        }
        if (src.hasStartedElement()) {
            tgt.setStartedElement(VersionConvertor_30_50.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
            tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUidElement())
            tgt.setUidElement((org.hl7.fhir.dstu3.model.OidType) VersionConvertor_30_50.convertType(src.getUidElement()));
        org.hl7.fhir.r5.model.Coding sop = src.getSopClass();
        if (URN_IETF_RFC_3986.equals(sop.getSystem())) {
            tgt.setSopClass(sop.getCode());
        }
        if (src.hasNumberElement())
            tgt.setNumberElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUidElement())
            tgt.setUidElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_30_50.convertType(src.getUidElement()));
        if (src.hasSopClass()) {
            org.hl7.fhir.r5.model.Coding c = new org.hl7.fhir.r5.model.Coding();
            c.setSystem(URN_IETF_RFC_3986);
            if (src.hasSopClassElement()) {
                c.setCodeElement((CodeType) VersionConvertor_30_50.convertType(src.getSopClassElement()));
            }
            tgt.setSopClass(c);
        }
        if (src.hasNumberElement())
            tgt.setNumberElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        return tgt;
    }
}