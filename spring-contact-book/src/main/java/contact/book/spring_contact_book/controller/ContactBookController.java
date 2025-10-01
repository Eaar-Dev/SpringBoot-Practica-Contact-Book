package contact.book.spring_contact_book.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contact.book.spring_contact_book.model.ContactBookModel;
import contact.book.spring_contact_book.service.ContactBookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact-book")
public class ContactBookController {

    private final ContactBookService contactBookService;

    public ContactBookController(ContactBookService contactBookService) {
        this.contactBookService = contactBookService;
    }

    @GetMapping
    public List<ContactBookModel> getAllContacts() {
        return contactBookService.getAll();
    }

    @GetMapping("/search")
    public List<ContactBookModel> searchByNameOrEmail(@RequestParam(required = false) String email,
            @RequestParam(required = false) String name) {
        if (email != null) {
            return contactBookService.searchByEmail(email);
        }
        if (name != null) {
            return contactBookService.searchByName(name);
        }
        return contactBookService.getAll();
    }

    @PostMapping
    public ResponseEntity<ContactBookModel> createNewContact(@Valid @RequestBody ContactBookModel contact) {
        ContactBookModel newContact = contactBookService.save(contact);

        return ResponseEntity.created(URI.create("/api/contact-book/" + newContact.getId()))
                .body(newContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactBookModel> updateContact(@PathVariable Long id,
            @Valid @RequestBody ContactBookModel contact) {
        return contactBookService.getById(id).map(existing -> {
            contact.setId(id);
            return ResponseEntity.ok(contactBookService.save(contact));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        return contactBookService.getById(id).map(ex -> {
            contactBookService.delete(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
