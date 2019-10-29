package com.swivel.mapper;

import com.swivel.dto.TicketDTO;
import com.swivel.model.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-18T22:09:21-0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class TicketToTicketDTOMapperImpl implements TicketToTicketDTOMapper {

    @Override
    public TicketDTO ticketToTicketDTO(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.set_id( ticket.get_id() );
        ticketDTO.setUrl( ticket.getUrl() );
        ticketDTO.setExternal_id( ticket.getExternal_id() );
        ticketDTO.setCreated_at( ticket.getCreated_at() );
        ticketDTO.setType( ticket.getType() );
        ticketDTO.setSubject( ticket.getSubject() );
        ticketDTO.setDescription( ticket.getDescription() );
        ticketDTO.setPriority( ticket.getPriority() );
        ticketDTO.setStatus( ticket.getStatus() );
        ticketDTO.setSubmitter_id( ticket.getSubmitter_id() );
        ticketDTO.setAssignee_id( ticket.getAssignee_id() );
        ticketDTO.setOrganization_id( ticket.getOrganization_id() );
        List<String> list = ticket.getTags();
        if ( list != null ) {
            ticketDTO.setTags( new ArrayList<String>( list ) );
        }
        ticketDTO.setHas_incidents( ticket.getHas_incidents() );
        ticketDTO.setDue_at( ticket.getDue_at() );
        ticketDTO.setVia( ticket.getVia() );

        return ticketDTO;
    }
}
